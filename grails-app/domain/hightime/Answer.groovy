package hightime

class Answer {
  String text
  Question question
  Participant answerer

  static constraints = {
    // question unqiue: answerer
    text maxSize: 1000
  }

  String toString() { 
    "Antwort (${question?.question}): ${text}"
  }
}
