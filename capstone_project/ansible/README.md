- [Ansible Challenge](#ansible-challenge)
  - [Objective](#objective)
  - [Pre-requisites](#pre-requisites)
  - [Setting up your environment](#setting-up-your-environment)
  - [Warm Up](#warm-up)
  - [Challenges](#challenges)
    - [Challenge 1 : Your first ansible playbook](#challenge-1--your-first-ansible-playbook)
    - [Challenge 2: Install apache2 in the target machines](#challenge-2-install-apache2-in-the-target-machines)
    - [Challenge 3: Using Ansible loops](#challenge-3-using-ansible-loops)
    - [Challenge 4: Using Ansible vars](#challenge-4-using-ansible-vars)
    - [Challenge 5: Using Ansible inventory groups](#challenge-5-using-ansible-inventory-groups)
    - [Challenge 6: Using Ansible Roles](#challenge-6-using-ansible-roles)
  - [Extra Bonus](#extra-bonus)
  - [Refereces](#refereces)
  - [Further Reading](#further-reading)

# Ansible Challenge

## Objective

By the end of this challenge, you will be able to install and use the Ansible to to administrate infrastructure.
## Pre-requisites

* [Docker](https://docs.docker.com/desktop/) installed
  * `docker --version` should show the docker version
* [Git](https://github.com/git-guides/install-git) installed
  * `git --version` should show the git version
* Have a [github account](https://github.com/join)
* Code editor of your preference - [VS Code](https://code.visualstudio.com/download) recommended
## Setting up your environment

1. Go to the github repository https://github.com/itjuana-bootcamp/DevOps
2. Fork the repository

NOTE: From here on, whenever we say repository , that refers to your forked repository.

5. Have docker desktop up and running.
6. Clone the repository : `git clone git@github.com:<githubaccount>/DevOps.git`
7. Go to the cloned repository and run the below commands.

```bash
cd ansible-challenge 
docker-compose up
```

8. After running the above command you will have 3 new containers running:

    * ansible_controller
    * ansible_target1
    * ansible_target2

NOTE: To be able to work with ansible we need 2 main components:

* ansible controller: This is the machine from where all the playbooks will be executed. Here is where ansible need to be installed.
* ansible target: This is the machine or machines that we are going to be managing through ansible.

## Warm Up

1. Update the inventory file located in the path: ansible_challenge/ansible_files/inventory.ini
2. These are the information related to the ansible target containers:
    * hostname: ansible_target1
    * user: ansible_controller
    * password: 12345
3. Open a new terminal and get into the controller machine 
   ```bash
   docker exec -w /home/ansible_controller/ansible_files/ -ti ansible_controller bash
   ```
4. Use ping module to check the connectivity from ansible_controller to ansible_target1
   ```bash
   ansible all -i inventory.ini -m ping
   ```
5. Create a file in target1
   ```bash
    ansible all -i inventory.ini -m command -a "sudo touch /home/ansible_controller/hello.txt"
   ```

## Challenges

### Challenge 1 : Your first ansible playbook
In this challenge , we will repeat the same activities we did above, BUT using a playbook.

1. Update the playbook.yml file located in the path ansible_challenge/ansible_files/playbook.yml in order to use the below modules:
* [ping module](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/ping_module.html) to check the connectivity to the ansible_target1 machine.
* [command module](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/command_module.html) or [file module](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/file_module.html) to create file in the target1 machine.

2. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```

NOTE: Please check if everything is green and nothing has failed.

**Nice!!! you executed your first ansible playbook**

### Challenge 2: Install apache2 in the target machines

1. Update inventory.ini file in ansible_challenge/ansible_files/inventory.ini to include ansible_target2 machine.
2. Update the playbook.yml file in the path ansible_challenge/ansible_files/playbook.yml in order to use the [apt module](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/apt_module.html) to install the apache2 package.
3. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```

**Congrats!!! you executed the ansible playbook to install apache in multiple target machines**

### Challenge 3: Using Ansible loops

It is very common to use [Ansible loop](https://docs.ansible.com/ansible/latest/user_guide/playbooks_loops.html) to execute a task multiple times. Let us see how!

1. Update the playbook.yml file in ansible_challenge/ansible_files/playbook.yml to install all the packages listed below using ansible loops:
    * jq
    * vim
    * python
2. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```
### Challenge 4: Using Ansible vars

Refer [Ansible variables](https://docs.ansible.com/ansible/latest/user_guide/playbooks_variables.html)

1. Create a vars file and move all the packages listed on the challenge before and reference those variable on the playbook.
2. Move the username and the password from the inventory.ini file to the vars file and use those variables in the inventory.ini file.
3. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```
**Awesome!! You have learned about ansible loops and variables**

### Challenge 5: Using Ansible inventory groups

1. Read about [Ansible inventory groups](https://docs.ansible.com/ansible/latest/user_guide/intro_inventory.html) and create 2 different groups using the ansible_target1 and ansible_target2 hosts. The name of those groups are up to you.
2. Edit the playbook.yml to install only the next packages on the group of the ansible_target1 host:
    * jq
   And the next packages for the group of the ansible_target2 host:
    * vim
    * python
3. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```
**Great!! Ansible groups is a useful and powerful feature while creating inventories, good job learning this functionality**

### Challenge 6: Using Ansible Roles

1. Read about [Ansible roles](https://docs.ansible.com/ansible/latest/user_guide/playbooks_reuse_roles.html) and create a new role to install apache2
2. Test your changes by running the next command.

   ```bash
   ansible-playbook -i inventory.ini playbook.yml
   ```
**Fantastic!!! Split your tasks by using Ansible roles is a good practice and a good optimization**

## Extra Bonus

* Update the ansible.cfg file in ansible_files/ansible.cfg and change the [strategy](https://docs.ansible.com/ansible/latest/user_guide/playbooks_strategies.html)

## Refereces

* [Ansible Documentation](https://docs.ansible.com/ansible/latest/)
* [Ansible Best Practices](https://docs.ansible.com/ansible/2.8/user_guide/playbooks_best_practices.html)

## Further Reading

* [Ansible Vault](https://docs.ansible.com/ansible/latest/user_guide/vault.html)
* [Ansible Collections](https://docs.ansible.com/ansible/latest/user_guide/collections_using.html)
* [Ansible Tower](https://docs.ansible.com/ansible/2.5/reference_appendices/tower.html)
