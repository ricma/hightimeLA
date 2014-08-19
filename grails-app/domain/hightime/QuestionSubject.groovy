package hightime

class QuestionSubject {
  String name

  static hasMany = [questions: Question]

  static constraints = {
    name unique: true, nullable: false
  }

  String toString() {
    name
  }
}
