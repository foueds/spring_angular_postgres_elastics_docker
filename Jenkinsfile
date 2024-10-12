pipeline {
    agent {
        docker {
            image 'maven:3-alpine' // Use the maven Docker image
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Mount Docker socket
        }
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from your Git repository
                git 'https://github.com/your-repo/project.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (if needed)
                echo 'Deploying application...'
            }
        }
    }

    post {
        always {
            // Actions to perform after every run (like cleanup)
            echo 'Pipeline completed'
        }
    }
}
