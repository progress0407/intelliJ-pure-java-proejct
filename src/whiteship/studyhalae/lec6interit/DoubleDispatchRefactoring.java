package whiteship.studyhalae.lec6interit;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatchRefactoring {

	interface Post {
		void postOn(SNS sns);
	}

	static class Text implements Post {
		public void postOn(SNS sns) {
			sns.post(this);
		}
	}

	static class Picture implements Post {
		public void postOn(SNS sns) {
			sns.post(this);
		}
	}

	interface SNS {
		void post(Text text);

		void post(Picture picture);
	}

	static class Facebook implements SNS {
		@Override
		public void post(Text text) {
			System.out.println("facebook - text");
		}

		@Override
		public void post(Picture picture) {
			System.out.println("facebook - picture");
		}
	}

	static class Twitter implements SNS {
		@Override
		public void post(Text text) {
			System.out.println("twitter - text");
		}

		@Override
		public void post(Picture picture) {
			System.out.println("twitter - picture");
		}
	}

	public static void main(String[] args) {
		List<Post> posts = Arrays.asList(new Text(), new Picture());
		List<SNS> sns = Arrays.asList(new Twitter(), new Facebook());
		posts.forEach(post -> sns.forEach(sn -> post.postOn(sn)));
	}
}
