pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Mount Docker socket
        }
    }
stages {
        stage('Build') {
            steps {
                script {
                    // Check if Docker is running in Jenkins container
                    sh 'docker --version'

                    // Run the build inside a Docker container
                    docker.image('maven:3.6.3-jdk-8').inside {
                        sh 'mvn clean install -DskipTests'
                    }
                }
            }
        }
    }
}
