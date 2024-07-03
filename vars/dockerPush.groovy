def call(String imageName, String credentialsId = 'docker-creds', String registry = 'https://hub.docker.com/repositories/henrykingiv') {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        echo "Logging into Docker registry: ${registry} with username: ${env.DOCKER_USERNAME}"
        sh """
            echo $DOCKER_PASSWORD | docker login --username $DOCKER_USERNAME --password-stdin $registry
        """
    }
    DockerUtils.push(imageName);
}

class DockerUtils {
    static void push(String imageName) {
        
        sh "docker push $imageName"
    }

    private static void sh(String script) {
        // This is a placeholder for the actual Jenkins sh step
        // In a Jenkins context, this would be executed as a shell script
        println "Executing shell script: ${script}"
    }
}
