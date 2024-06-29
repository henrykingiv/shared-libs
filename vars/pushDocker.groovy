def call(String imageName, String credentialsId = 'docker-creds', String toolName = 'docker') {
    pushDocker(imageName, credentialsId, toolName)
}

private void pushDocker(String imageName, String credentialsId, String toolName) {
    sh "docker push ${imageName}"
}
