pipeline {
    agent {
        docker {
            image 'maven:3.8.7-openjdk-18-slim'  // Use the correct and available Maven Alpine image
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Mount Docker socket
        }
    }
    stages {
            stage('Build') {
                steps {
                    sh 'mvn clean install -DskipTests'
                }
            }
    }
}
