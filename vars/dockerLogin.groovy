def call(String credentialsId = 'docker-creds', String registry = 'https://index.docker.io/v1/') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            docker login -u ${DOCKER_USERNAME} -password-stdin ${DOCKER_PASSWORD} ${registry}
        """
    }
}
