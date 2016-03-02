module DNA (toRNA) where

replace :: Char -> Char
replace letter | letter == 'G' = 'C'
               | letter == 'C' = 'G'
               | letter == 'T' = 'A'
               | letter == 'A' = 'U'
               | otherwise = ' '
           
toRNA :: String -> String
toRNA dna = map replace dna