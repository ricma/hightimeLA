import hightime.QuestionSubject
import hightime.Question

class BootStrap {

  def init = { servletContext ->
    def lu = new QuestionSubject(name: "Lu")
    def alex = new QuestionSubject(name: "Alex")

    lu.addToQuestions(
      new Question(question: "Was ist Ihr Lieblingsgetränk?",
                   subject: lu))

    lu.addToQuestions(
      new Question(question: """\
Wenn sie ihm einen Pullover kaufte, welche Farbe würde sie wählen?""",
                   subject: lu))

    alex.addToQuestions(
      new Question(question: """\
In welches Land würde er gern als nächstes reisen?""",
                   subject: alex))

    alex.addToQuestions(
      new Question(question: """\
Welches Gewürz benutzt er am liebsten beim Kochen?""",
                   subject: alex))

    lu.save(failOnError: true)
    alex.save(failOnError: true)
  }
  def destroy = {
  }
}
