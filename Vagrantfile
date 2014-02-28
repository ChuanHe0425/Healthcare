Vagrant.configure("2") do |config|
  ## Choose your base box
  config.vm.box = "precise64"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  ## For masterless, mount your file roots file root
  config.vm.synced_folder "salt/roots/", "/srv/"
  
  ## Setup roncare.org in the webapps folder
  config.vm.synced_folder "roncare.org/", "/var/lib/tomcat7/webapps/roncare.org/"
  
  ## Setup roncare.org in the webapps folder
  config.vm.synced_folder "sql/", "/srv/sql/"

  ## Set Host only access address
  config.vm.network :private_network, ip: "10.9.8.7"
  
  ## Set port forwarding
  ## Http port for phpmyadmin
  config.vm.network :forwarded_port, guest: 80, host: 8888
  
  ## MySQL port
  config.vm.network :forwarded_port, guest: 3306, host: 8308
  
  ## Eclipse debug port
  config.vm.network :forwarded_port, guest: 8000, host: 8000
  
  ## Tomcat port
  config.vm.network :forwarded_port, guest: 8080, host: 8080
  
  
  ## Set your salt configs here
  config.vm.provision :salt do |salt|

    ## Minion config is set to ``file_client: local`` for masterless
    salt.minion_config = "salt/minion"

    ## Installs our example formula in "salt/roots/salt"
    salt.run_highstate = true

  end
end
