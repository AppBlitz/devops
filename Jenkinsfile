pipeline {
    agent any

    environment {
        IMAGE_NAME = 'miusuario/devops-app'  
    }
        stage('Clonar') {
            steps {
                git branch: 'main', url: 'https://github.com/AppBlitz/devops.git'
                }
        }

        stage('Compilar aplicación') {
            steps {
                sh './gradlew bootJar'
            }
        }

        stage('Construir imagen Docker') {
            steps {
                script {
                    docker.build(IMAGE_NAME)
                }
            }
        }

        stage('Subir a Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    script {
                        docker.image(IMAGE_NAME).push('latest')
                    }
                }
            }
        }
        stage('Desplegar en Kubernetes') {
            steps {
                script{
                    KubernetesDeploy(configs: 'k8s/app-deployment.yaml', 'k8s/mongo-deployment.yaml')
                }
            }
        }
    }
}
    
