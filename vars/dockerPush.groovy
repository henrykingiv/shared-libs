def call(String imageName, String registry = '', String credentialsId = '') {
    DockerUtils.push(imageName, registry, credentialsId)
}

class DockerUtils {
    static void push(String imageName, String registry, String credentialsId) {
        if (registry) {
            imageName = "${registry}/${imageName}"
        }

        if (credentialsId) {
            withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin ${registry}"
            }
        }

        sh "docker push ${imageName}"
    }
}
