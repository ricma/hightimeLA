import hightime.QuestionSubject
import hightime.Question
import hightime.Answer
import hightime.Participant

class BootStrap {

  def init = { servletContext ->
    def lu = new QuestionSubject(name: "Lu")
    def alex = new QuestionSubject(name: "Alex")
    def both = new QuestionSubject(name: "Beide")

    lu.addToQuestions(
      new Question(question: "Was ist Ihr Lieblingsgetränk?",
                   subject: lu))

    lu.addToQuestions(
      new Question(question: """\
Wenn sie ihm einen Pullover kaufen würde, welche Farbe würde sie wählen?""",
                   subject: lu))

    lu.addToQuestions(
      new Question(question: """\
Welches Haustier würde sie niemals in die Wohnung lassen?""",
                   subject: lu))

    lu.addToQuestions(
      new Question(question: """\
Welche Charktereigenschaft schätzt sie an ihm am meisten?""",
                   subject: lu))

    both.addToQuestions(
      new Question(question: """\
Bei welcher nutzlosen Kleinigkeit kommen sie sich am ehesten in die Haare?""",
                   subject: both))

    both.addToQuestions(
      new Question(question: """\
Wieviele Partner hatten beide vorher in Summe?""",
                   subject: both))

    alex.addToQuestions(
      new Question(question: """\
In welches Land würde er gern als nächstes reisen?""",
                   subject: alex))

    alex.addToQuestions(
      new Question(question: """\
Welches Gewürz benutzt er am liebsten beim Kochen?""",
                   subject: alex))

    alex.addToQuestions(
      new Question(question: """\
Was ist seine Lieblingseissorte?""",
                   subject: alex))

    alex.addToQuestions(
      new Question(question: """\
Welche Charktereigenschaft schätzt er an ihr am meisten?""",
                   subject: alex))

    lu.save(failOnError: true)
    alex.save(failOnError: true)
    both.save(failOnError: true)
    
    lu.questions.each { it.save failOnError: true }
    alex.questions.each { it.save failOnError: true }
    both.questions.each { it.save failOnError: true }

    // also add some persons as quests
    def me = new Participant(name: "Martin Richter")
    me.addToAnswers(
      new Answer(question: alex.questions[1],
                 answerer: me,
                 text: "Salz in der Suppe"))
    me.save(failOnError: true)
  }
  def destroy = {
  }
}
