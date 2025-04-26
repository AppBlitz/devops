pipeline {
    agent any

    environment {
        IMAGE_NAME = 'miusuario/devops-app'  
    }

<<<<<<< HEAD
    stages {
        

        stage('Instalar JDK 21') {
            steps {
                sh 'sudo apt-get update && sudo apt-get install -y openjdk-21-jdk'
            }
        }  
             
=======
    stages {   
        
>>>>>>> 69e3fbaafb417b66ce99162d59393bbed4f03f19
        stage('Compilar aplicación') {
            steps {
                sh './gradlew bootJar'
            }
        }

        stage('Construir imagen Docker') {
            steps {
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }

        stage('Subir a Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    script {
                        docker.image(DOCKER_IMAGE).push('latest')
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
    
