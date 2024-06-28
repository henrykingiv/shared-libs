def call(String dockerUsername = '', String dockerPassword = '', String registry = '') {
  sh "docker login --username ${dockerUsername} --password-stdin ${dockerPassword} ${registry}"
}
