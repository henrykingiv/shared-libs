def call(String credentialsId = '', String registry = '') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} -password-stdin ${DOCKER_PASSWORD} ${registry}
        """
    }
}
