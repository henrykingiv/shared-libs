def call(String repoUrl, String branch){
def workingDir = "${env.WORKSPACE}"
sh "git pull ${repoUrl} ${workingDir}"
dir(workingDir) {
sh "git checkout ${branch}"
}
return workingDir
}
