def call(String imageName, String context = '.'){
  dockerBuild(imageName)
}

private void dockerBuild(String imageName, String context) {
  def cmd = "docker buildx build -t ${imageName} ${context}"
  echo "Executing: ${cmd}"
  sh cmd
}
