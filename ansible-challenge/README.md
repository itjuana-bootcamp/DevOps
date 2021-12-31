# Ansible Challenge

## Objective

By the end of this challenge, you will be able to install and use the Ansible configuration management to to administrate infrastructure

## Official documentation

* [Ansible Documentation](https://docs.ansible.com/ansible/latest/user_guide/intro_getting_started.html)
* [Docker compose](https://docs.docker.com/compose/)

## Tools Needed

* [Docker](https://docs.docker.com/desktop/mac/install/) installed
* Code editor of your preference - [VS Code](https://code.visualstudio.com/download) recommended
* [Git](https://github.com/git-guides/install-git) installed on your machine

## Get your local env ready

1. Clone this repo.
2. Have docker desktop up and running.
3. Go to ansible-challenge directory and run the next command.

```bash
docker-compose up
```

1. After running the above command you will have 3 new containers running:
    * ansible_controller
    * ansible_target1
    * ansible_target2

NOTE: To be able to work with ansible we need 2 main components:

* ansible controller: This is the machine from where all the playbooks will be executed. Here is where ansible need to be installed.
* ansible target: This is the machine or machines that we are going to be managing through ansible.

## Challenge

NOTE: Please be aware , the containers we are using are having Ubuntu OS.
### Challenge 1 : Check connectivity from controller to target machines

1. Ctrl+C to stop the docker container.
2. Update the inventory file located on the next path: /home/ansible_controller/ansible_files/inventory.ini. These is the information related to the ansible target containers:
    * hostname: ansible_target1, ansible_target2
    * user: ansible_controller
    * password: 12345
3. Update the playbook.yml file located on the next path /home/ansible_controller/ansible_files/playbook.yml in order to use the [ping module](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/ping_module.html) to check the connectivity.
4. Go to ansible-challenge directory and run the next command, in order to take all the changes into the container - ansible-controller.

```bash
docker-compose up
```

5. Open a new terminal and run the next command to go inside the ansible_controller docker container in order to execute the playbook.

```bash
docker exec -w /home/ansible_controller/ansible_files/ -ti ansible_controller bash
```

6. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```

NOTE: Please check if everything is green and nothing has failed.

1. Execute the next command to exit from the ansible-controller

```bash
exit
```

### Nice!!! you executed your first ansible playbook and to check the connectivity between the controller and targets

### Challenge 2: Install apache2 in the target machines

1. Ctrl+C on the previous terminal to stop the docker container.
2. Update the playbook.yml file located on the next path /home/ansible_controller/ansible_files/playbook.yml in order to use the [apt module](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/apt_module.html) to install the apache2 package.
3. Repeat steps 4 to 6 from Challenge#1 to test the changes

### Congrats!!! you executed the ansible playbook to install apache in multiple target machines

### Challenge 3: Using Ansible loops

It is very common to use [Ansible loop](https://docs.ansible.com/ansible/latest/user_guide/playbooks_loops.html) to execute a task multiple times. Let us see how!

1. Ctrl+C on the previous terminal to stop the docker container.
2. Update the playbook.yml file located on the next path /home/ansible_controller/ansible_files/playbook.yml to install all the packages listed below using ansible loops:
    * jq
    * vim
    * python
3. Repeat steps 4 to 6 from Challenge#1 to test the changes

### Challenge 4: Using Ansible vars

Refer [Ansible variables](https://docs.ansible.com/ansible/latest/user_guide/playbooks_variables.html)

1. Ctrl+C on the previous terminal to stop the docker container.
2. Create a vars file and move all the packages listed on the challenge before and reference those variable on the playbook.
3. Move the hostname, the username and the password from the inventory.ini file to the vars file and use those variables in the inventory.ini file.
4. Repeat steps 4 to 6 from Challenge#1 to test the changes.

### Awesome!! You have learned about ansible loops and variables

### Challenge 5: Using Ansible inventory groups

1. Read about [Ansible inventory groups](https://docs.ansible.com/ansible/latest/user_guide/intro_inventory.html) and create 2 different groups using the ansible_target1 and ansible_target2 hosts. The name of those groups are up to you.
2. Edit the playbook.yml to install only the next packages on the group of the ansible_target1 host:
    * jq
   And the next packages for the group of the ansible_target2 host:
    * vim
    * python
3. Run again the playbook and verify the execution is completed successfully

### Great!! Ansible groups is a useful and powerful feature while creating inventories, good job learning this functionality

### Challenge 6: Using Ansible Roles

1. Read about [Ansible roles](https://docs.ansible.com/ansible/latest/user_guide/playbooks_reuse_roles.html) and [Ansible galaxy](https://docs.ansible.com/ansible/latest/cli/ansible-galaxy.html) and create a new role to do the next steps:
    * Install all these packages
        * jq
        * vim
        * python
        * apache2
    * Update the index.html file for the apache2 package and put the next content: "Hello from Ansible"
    * Restart apache2

### Fantastic!!! Split your tasks by using Ansible roles is a good practice and a good optimization

## Extra Bonus

* Update the ansible.cfg file located on the next path: /home/ansible_controller/ansible_files and change the [deployment strategy](https://docs.ansible.com/ansible/latest/user_guide/playbooks_strategies.html)
* Store some sensitive data on [Ansible Vault](https://docs.ansible.com/ansible/latest/user_guide/vault.html) and use it on the playbook
