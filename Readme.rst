Download Grails
---------------

..code: bash

  sudo mkdir /opt/grails
  sudo chown martin:martin /opt/grails
  cd /opt/grails

  curl -O http://dist.springframework.org.s3.amazonaws.com/release/GRAILS/grails-2.4.3.zip

  unzip grails-*.zip

Set up environment
------------------

Besides these two you have to make sure that ``${JAVA_HOME}`` points to
a *JDK*, not a *JRE*.

..code: bash

  export GRAILS_HOME=/opt/grails/grails-2.4.3
  export PATH="${GRAILS_HOME}/bin:${PATH}"

  # if not yet done:
  export JAVA_HOME="/usr/lib/jvm/java-7-openjdk-amd64/"

  # test if everything is running
  grails --version

Set up an example
-----------------

This follows the `online example
<http://grails.org/doc/latest/guide/gettingStarted.html#requirements>`__.

..code: bash

  cd ~/Arbeit/Groovy/Grails
  grails create-app helloworld
  cd helloworld
  grails

The last command starts the *grails console*.

Create content for the example
------------------------------

For every new page you want to be shown, you have to add a controller:

..code: grails-console

  grails> create-controller hello

This yields a new controller in
``grails-app/controllers/helloworld/HelloController.groovy``. Add some
code to get a *Hello World*:

..code: groovy

  class HelloController {

    def index() {
      render "Hallo World"
    }
  }

and run it from the grails shell with ``grails> run-app
-Dserver.port=40080`` and `visit the grails start page
<http://localhost:40080/helloworld>`__ to get to `your app
<http://localhost:40080/helloworld/hello/index>`__. You may stop it with
``grails> stop-app``. In order to deploy the app on a JavaEE application
server, use ``grails> war``.

Creating useful content
-----------------------

First you need a domain class. This is what represents persistent data

..code: grails-console

  grails> create-domain hightime.Question hightime.QuestionSubject
  grails> create-domain hightime.Participant hightime.Answer

Go to the `grails-app/domain/hightime/Question.groovy` and add
some properties:

..code: groovy

  package hightime

  class Question {
    QuestionSubject subject
    String question

    static hasMany = [answers: Answer]

    static constraints = {
      subject nullable: false
      question unique: subject
    }
  }

Do the same for the other domain classes. Now add a controller for
entering questions: Note that we use the very same name for it!

..code: grails-console

  grails> create-controller hightime.Question

The most simple UI can be obtained by using:

..code: grails

  package hightime

  class QuestionController {
  // we could also use `true` as a value here
    static scaffold = Question
  }

Now create scaffolding-controllers for all domain classes you want to be
able to edit as well. In our case, it is only Participant because we
will give the QuestionSubject and Questions programmatically later.

You can now run this simple application by using ``grails> run-app
-Dserver.port=40080``

Improve templates
-----------------

In order to alter the way the app looks like, do ``grails>
install-template``.

