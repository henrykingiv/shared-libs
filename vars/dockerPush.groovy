def call(String imageName, String registry = '', String credentialsId = '') {
    DockerUtils.push(imageName, registry, credentialsId)
}
