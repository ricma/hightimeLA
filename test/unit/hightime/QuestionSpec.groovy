package hightime

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Question)
class QuestionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
      def lu = new QuestionSubject(name: "Lu")
      def alex = new QuestionSubject(name: "Alex")
      def q

      q = new Question(question: "Was ist Ihr Lieblingsgetränk?")
      q.subject = lu
      lu.questions << q

      q = new Question(question: """\
Wenn sie ihm einen Pullover kaufte, welche Farbe würde sie wählen?""")
      q.subject = lu
      lu.questions << q

      q = new Question(question: "In welches Land würde er gern als nächstes reisen?")
      q.subject = alex
      alex.questions << q

      q = new Question(question: """\
Welches Gewürz benutzt er am liebsten beim Kochen?""")
      q.subject = alex
      alex.questions << q

    }
}
