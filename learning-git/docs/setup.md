# Setup git

### installation

* Mac
```
brew install git
```

* Ubuntu
```
sudo apt install git
```

* Windows, download the executable binary from [here](https://git-scm.com/download/win)

### Setup ssh keys
```
ssh-keygen –t rsa
```

Run `cat ~/.ssh/id_rsa.pub` and bopy the output and put it into https://github.com/settings/keys 

### Setup email and name
```
git config --global user.email “richistron@gmail.com”
git config --global user.name “Ricardo Rivas”
```

