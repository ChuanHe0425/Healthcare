
#CS 673 Health Care Project

This is the top level README file for the project. It is formatted with **markdown**.  

+ [about markdown](http://daringfireball.net/projects/markdown/)  
+ [markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

This file is located at the root level of the project and is a good place for introductory/high-level project documentation.

##Git

###Getting started with git
You will need to have git installed on your machine in order to proceed.

**Introduction**
The following links are good introductions and refreshers on git:

+ [a simple guide](http://rogerdudler.github.io/git-guide/) 
+ [git basics](https://www.atlassian.com/git/tutorial/git-basics)

**Interface**

+ you can run git commands at the command line or install a GUI
+ [SourceTree](http://www.sourcetreeapp.com/) is an excellent GUI

**Pull files from the command line**  
To pull this repo from the command line

+ cd to a directory on your machine that will contain your working copy
+ execute the git clone command, like so:  
$ git clone https://yourbitbucketusername@bitbucket.org/farrellc/healthcare.git

###Conventions for git
We should discuss these, of course, but I wanted to get some initial thoughts out there.

**Branching**  
We need to have a simple, yet sensible branching strategy. 

+ [Here is an excellent, and proven model](https://gist.github.com/jbenet/ee6c9ac48068889b0912)

**Commits**  
Please commit small changes, frequently, with clear and concise messages.

+ [wikipedia says it well](http://en.wikipedia.org/wiki/Atomic_commit#Atomic_Commit_Convention)

**Commit messages**  
Please format your commit messages with a declarative statement that completes the sentence "This commit ..."

+ for example, I will check in the changes I am making now like this: $ git push -m "adds git conventions to the README"

**gitignore**  
We will need to add to the .gitignore file as we go.

+ [here are a few examples](http://www.sujee.net/tech/articles/gitignore/)