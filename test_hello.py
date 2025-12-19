import unittest
from hello import say_hello

class TestHello(unittest.TestCase):
    def test_say_hello(self):
        # 결과가 "Hello Jenkins!"가 맞는지 확인
        self.assertEqual(say_hello(), "Hello Jenkins!")

if __name__ == '__main__':
    unittest.main()