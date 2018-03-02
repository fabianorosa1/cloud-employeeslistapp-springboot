# Application links in SCP CF

https://employeeslist-java.cfapps.eu10.hana.ondemand.com/employees

https://employeeslist-java.cfapps.eu10.hana.ondemand.com/create

https://approuter-springboot.cfapps.eu10.hana.ondemand.com

https://S0017254285trial.authentication.eu10.hana.ondemand.com/config?action=who

# Blogs and tutorials about this scenario

https://blogs.sap.com/2015/12/08/sap-hana-sps-11-new-developer-features-hdi/

https://help.sap.com/doc/4505d0bdaf4948449b7f7379d24d0f0d/2.0.01/en-US/b3092cdd8e754a08a9e86006a53c4cca.html

https://www.sap.com/developer/tutorials/xsa-hdi-module.html

https://blogs.sap.com/2017/05/15/step-1-with-sap-s4hana-cloud-sdk-set-up/
https://blogs.sap.com/2017/05/19/step-3-with-sap-s4hana-cloud-sdk-helloworld-on-scp-cloudfoundry/
https://blogs.sap.com/2017/05/21/step-4-with-sap-s4hana-cloud-sdk-calling-an-odata-service/
https://blogs.sap.com/2017/06/23/step-5-resilience-with-hystrix/
https://blogs.sap.com/2017/12/20/deep-dive-6-with-sap-s4hana-cloud-sdk-extend-your-cloud-foundry-application-with-tenant-aware-persistency/
** https://blogs.sap.com/2017/07/18/step-7-with-sap-s4hana-cloud-sdk-secure-your-application-on-sap-cloud-platform-cloudfoundry/
https://blogs.sap.com/2017/09/11/step-10-with-sap-s4hana-cloud-sdk-virtual-data-model-for-odata/
https://blogs.sap.com/2017/09/19/step-12-with-sap-s4hana-cloud-sdk-automated-testing/
https://blogs.sap.com/2017/09/19/step-12-with-sap-s4hana-cloud-sdk-automated-testing/
https://blogs.sap.com/2017/09/20/continuous-integration-and-delivery/
https://blogs.sap.com/2017/12/07/step-19-with-s4hana-cloud-sdk-mocking-s4hana-calls-or-how-to-develop-an-s4hana-extension-without-an-s4hana-system/

# NPM commands

npm config set @sap:registry https://npm.sap.com

# CF commands

cf -help -a

java -jar mta.jar -build-target=CF build

cf deploy cloud-employeeslistapp-springboot.mtar

cf create-service xsuaa application xsuaa-springboot -c xs-security.json

cf allow-space-ssh SPACE_NAME

cf enable-ssh APP_NAME

cf security-groups

cf security-group SECURITY_GROUP

cf ssh -L localhost:30015:<host>:<port> <application_name> -N

cf m  

cf cs application-logs lite app-logs  

cf bs employeeslist-java app-logs 

cf restage employeeslist-java

https://docs.cloudfoundry.org/devguide/deploy-apps/ssh-apps.html

C:\Users\fabiano.a.rosa>cf curl /v2/info

{
   "name": "",
   "build": "",
   "support": "https://help.cf.eu10.hana.ondemand.com",
   "version": 0,
   "description": "Cloud Foundry at SAP Cloud Platform",
   "authorization_endpoint": "https://login.cf.eu10.hana.ondemand.com",
   "token_endpoint": "https://uaa.cf.eu10.hana.ondemand.com",
   "min_cli_version": null,
   "min_recommended_cli_version": null,
   "api_version": "2.98.0",
   "app_ssh_endpoint": "ssh.cf.eu10.hana.ondemand.com:2222",
   "app_ssh_host_key_fingerprint": "f3:12:47:b5:3a:19:6e:6c:4e:9d:90:2e:6f:8e:87:cc",
   "app_ssh_oauth_client": "ssh-proxy",
   "doppler_logging_endpoint": "wss://doppler.cf.eu10.hana.ondemand.com:443"
}


ssh -p 2222 cf:f3:12:47:b5:3a:19:6e:6c:4e:9d:90:2e:6f:8e:87:cc/0@ssh.cf.eu10.hana.ondemand.com

mvn install:install-file -Dfile=ngdbc.jar -DgroupId=com.sap.db.jdbc -DartifactId=ngdbc -Dversion=2.0.14 -Dpackaging=jar
 
 
