package hightime

class Participant {
  String name

  static hasMany = [answers: Answer]

  static constraints = {
    name unique: true
  }

  String toString() { 
    "Hochzeitsgast: ${name}"
  }
}
