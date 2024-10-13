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
                    // Install Docker inside the container
                    sh '''
                    apk update
                    apk add docker-cli
                    docker --version
                    '''

                    // Run the build inside a Docker container
                    docker.image('maven:3.6.3-jdk-8').inside {
                        sh 'mvn clean install -DskipTests'
                    }
                }
            }
        }
    }
}
