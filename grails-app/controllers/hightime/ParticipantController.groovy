package hightime

class ParticipantController {
  static scaffold = Participant

  // accessible via
  //   http://host:port/appName/participant
  // or
  //   http://host:port/appName/participant/index
  def index = {

    def subjects = QuestionSubject.list()

    def questions = Question.list().groupBy {
      q -> q.subject }


    // This map is the model of the view
    return [questionsBySubject: questions,
            subjects: subjects]
  }
}
