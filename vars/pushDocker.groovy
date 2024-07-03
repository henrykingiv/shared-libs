def call(String imageName, String credentialsId = 'docker-creds', String toolName = 'docker') {
    DockerPushClass sujit=new DockerPushClass()
    sujit.pushDocker(imageName, credentialsId, toolName)

    sujit.callingPrivateMethod(imageName, credentialsId, toolName)
    
    DockerPushClass.pushDockerStatic(imageName, credentialsId, toolName)
    
}

class DockerPushClass {
    public void pushDocker(String imageName, String credentialsId, String toolName) {
        System.out.println("dockerPushMethod: " + imageName)
        sh "docker push ${imageName}"
    }

    static void pushDockerStatic(String imageName, String credentialsId, String toolName) {
        sh "docker push ${imageName}"
    }

    private void pushDockerPrivate(String imageName, String credentialsId, String toolName) {
        sh "docker push ${imageName}"
    }

    public void callingPrivateMethod(String imageName, String credentialsId, String toolName) {
        pushDockerPrivate(imageName, credentialsId, toolName)
    }
}
