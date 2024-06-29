def call(String imageName, Strong context = '.'){
  dockerBuild(imageName)
}

private void dockerBuild(String imageName, String context) {
  def cmd = "docker build -t ${imageName} ${context}"
  echo "Executing: ${cmd}"
  sh cmd
}
