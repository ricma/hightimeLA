package hightime

class Question {
  QuestionSubject subject
  String question

  static hasMany = [answers: Answer]

  static constraints = {
    subject nullable: false
    question unique: subject, blank: false, maxSize: 1000
  }

  String toString() {
    "${subject.name}: ${question}"
  }
}
