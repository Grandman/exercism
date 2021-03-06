class Squares
	def initialize(digit)
		@digit = digit
	end
	def square_of_sums
		(1..@digit).reduce(:+) ** 2
	end
	def sum_of_squares
		(1..@digit).map{|item| item**2}.reduce(:+)
	end
	def difference
		square_of_sums-sum_of_squares
	end
end