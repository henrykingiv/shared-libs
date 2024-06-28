def call(String dockerUsername = '', String dockerPassword = '', String registry = '') {
  sh """
        echo ${dockerPassword} | docker login --username ${dockerUsername} --password-stdin ${registry}
    """
}
