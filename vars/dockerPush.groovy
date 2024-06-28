def call(String imageName, String credentialsId = '', String registry = '') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        echo "Logging into Docker registry: ${registry} with username: ${env.DOCKER_USERNAME}"
        sh """
            echo ${DOCKER_PASSWORD} | docker login --username ${DOCKER_USERNAME} --password-stdin ${registry}
        """
    }
}

class DockerUtils {
    static void push(String imageName, String registry = '', String username = '', String password = '') {
        if (registry) {
            imageName = "${registry}/${imageName}"
        }

        if (username && password) {
            sh "echo ${password} | docker login -u ${username} --password-stdin ${registry}"
        }

        sh "docker push ${imageName}"
    }

    private static void sh(String script) {
        // This is a placeholder for the actual Jenkins sh step
        // In a Jenkins context, this would be executed as a shell script
        println "Executing shell script: ${script}"
    }
}
