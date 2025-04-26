pipeline {
    agent any

    environment {
        IMAGE_NAME = 'jahncm/devops-app'
    }

    stages {
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
                sh 'kubectl apply -f k8s/mongo-deployment.yaml'
                sh 'kubectl apply -f k8s/app-deployment.yaml'
            }
        }
    }
}

    
