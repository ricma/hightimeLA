package hightime

class Question {
  QuestionSubject subject
  String question

  static hasMany = [answers: Answer]

  static constraints = {
    subject nullable: false
    question blank: false, maxSize: 1000 //, unique: subject
    // FIXME: The unique constraint lets the compilation fail
    // with: groovy.lang.MissingPropertyException:
    //   No such property: subject for class: hightime.Question
    //   Possible solutions: subject
  }

  String toString() {
    "${subject.name}: ${question}"
  }
}
