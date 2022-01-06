git checkout
============

The checkout command allows to switch branches or go back to specific versions

The parameter `-b` allows you to create a branch
```
git checkout -b <branch_name> <optional_remote_branch>
```

You can also reset a branch by telling the route of the file
```
git checkout -- <path_to_file>
```

If you want to return one file to an specific version you could do it like this
```
git checkout <commit>^ -- <ruta_archivo>
```