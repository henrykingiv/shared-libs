def call(String imageName, String registry = '', String credentialsId = '') {
    if (credentialsId) {
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
            DockerUtils.push(imageName, registry, env.DOCKER_USERNAME, env.DOCKER_PASSWORD)
        }
    } else {
        DockerUtils.push(imageName, registry)
    }
}

class DockerUtils {
    static void push(String imageName, String registry = 'https://hub.docker.com/repositories/henrykingiv', String username = 'docker-username', String password = 'docker-password') {
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
