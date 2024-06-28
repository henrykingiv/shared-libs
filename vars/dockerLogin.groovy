def call(String credentialsId = 'docker-hub-credentials', String registry = 'https://index.docker.io/v1/') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            echo ${DOCKER_PASSWORD} | docker login --username ${DOCKER_USERNAME} --password-stdin ${registry}
        """
    }
}
