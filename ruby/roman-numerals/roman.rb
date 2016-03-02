class Fixnum
  def to_roman
    hash = {
      1000 => "M",
      500 => "D",
      100 => "C",
      50 => "L",
      10 => "X",
      5 => "V",
      1 => "I"
    }
    
    tmp = self.to_s.chars.map(&:to_i)
    result = ""
    tmp.each.with_index do |i, index|
      next if i == 0
      pos = tmp.count - index
      power = pos - 1

      if hash.include? i * 10 ** power
        result += hash[i * 10 ** power]
        next
      end

      if i > 1 && i < 4
        result += hash[1 * 10 ** power] * i
        next
      end

      if i == 4 
        result += hash[1 * 10 ** power] + hash[5 * 10 ** power]
        next
      end

      if i > 5 && i < 9
        result += hash[5 * 10 ** power] + hash[1 * 10 ** power] * (i - 5)
        next
      end

      if i == 9
        result += hash[1 * 10 ** power] + hash[1 * 10 ** (power + 1)]
        next
      end
    end
    result
  end
end
