pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        IMAGE_NAME = 'jahncm/devops-app'
    }

    stages {

        stage('Verificar rama') {
            when {
                branch 'main'
            }
            steps {
                echo 'Este pipeline solo se ejecuta en la rama main'
            }
        }

        stage('Compilar aplicación') {
            steps {
                sh './gradlew bootJar'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Publicar reportes JUnit') {
            steps {
                junit 'build/test-results/test/*.xml'
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
            environment {
                KUBECONFIG = '/var/lib/jenkins/.kube/config'
            }
            steps {
                sh 'kubectl apply -f k8s/mongo-deployment.yaml'
                sh 'kubectl apply -f k8s/app-deployment.yaml'
            }
        }
    }
}

    
