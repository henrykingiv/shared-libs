def call(String credentialsId = 'docker-creds', String registry = 'https://hub.docker.com/repositories/henrykingiv') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            echo ${DOCKER_PASSWORD} | docker login --username ${DOCKER_USERNAME} --password-stdin ${registry}
        """
    }
}
