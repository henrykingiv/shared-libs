# shared-libs

# Jenkins Shared Libraries

What are Jenkins Shared libraries??

As we adopt pipelines into different projects in an organisation, similar patterns are likely to emerge. Sometimes we end up sharing similar parts of pipelines between various projects to reduce redundancies and keep codes 'DRY'.
This is where shared libraries come into play, it involves using common codes patterns stored in a remote repository and calling the code into multiple Jenkins pipeline projects. 

Pipeline has support for creating shared libraries which can be defined in external source control repositories and loaded into existing pipelines.
