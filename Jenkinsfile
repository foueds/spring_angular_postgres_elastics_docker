pipeline {
    agent {
        docker {
            image 'docker:19.03'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'docker --version'  // Verify Docker is available
                    sh 'docker pull maven:3-alpine'
                }
            }
        }
    }
}
