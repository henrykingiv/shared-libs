def call(String credentialsId = 'docker-hub-credentials', String registry = 'https://index.docker.io/v1/') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            echo ${DOCKER_PASSWORD} | docker login --username ${DOCKER_USERNAME} --password-stdin ${registry}
        """
    }
}

class DockerUtils {
    static void push(String imageName, String registry = 'https://hub.docker.com/repositories/henrykingiv', String username, String password) {
        if (registry) {
            imageName = "${registry}/${imageName}"
        }

        sh "echo ${password} | docker login --username ${username} --password-stdin ${registry}"
        // sh "docker push ${imageName}"
    }

    private static void sh(String script) {
        // This is a placeholder for the actual Jenkins sh step
        // In a Jenkins context, this would be executed as a shell script
        println "Executing shell script: ${script}"
    }
}
