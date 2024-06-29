def call(String credentialsId = '', String registry = '') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            echo ${DOCKER_PASSWORD} | docker login --username ${DOCKER_USERNAME} --password-stdin ${registry}
        """
    }
}
