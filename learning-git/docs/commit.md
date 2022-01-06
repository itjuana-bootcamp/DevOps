git commit
==========

The git commit command captures a snapshot of the project's currently
staged changes. Committed snapshots can be thought of as **safe**
versions of a project—Git will never change them unless you explicitly ask
it to.

### Simple commit

Example:
```
git commit -m "my first commit"
```

### Adding al files and creating a commit

Example:
```
git commit -am "my first commit"
```

### Interactive commit

This will open up an editor, this could variate from distro to distro but it
will usually use **vim** or **nano**. You can specify the editor you like
by setting up `$EDITOR` variable

Example:
```
git commit
```

Adds all the files and open an interactive editor
```
git commit -a
```

Using VSCode as interactive editor

```
EDITOR=code git commit
```
