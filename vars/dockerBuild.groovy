def call(String imageName){
  dockerBuild(imageName)
}

private void dockerBuild(String imageName) {
  def cmd = "docker build -t ${imageName}"
  echo "Executing: ${cmd}"
  sh cmd
}
