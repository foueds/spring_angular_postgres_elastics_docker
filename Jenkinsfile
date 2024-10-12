pipeline {
    agent {
        docker {
            image 'docker:19.03'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
}
