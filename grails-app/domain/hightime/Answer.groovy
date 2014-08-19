package hightime

class Answer {
  String text
  Question question
  Participant answerer

  static constraints = {
    // question unqiue: answerer
  }

  String toString() { 
    "Antwort (${question?.question}): ${text}"
  }
}
